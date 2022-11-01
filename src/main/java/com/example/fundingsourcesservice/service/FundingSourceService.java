package com.example.fundingsourcesservice.service;

import com.example.fundingsourcesservice.data.*;
import com.example.fundingsourcesservice.entity.BankAccount;
import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import com.example.fundingsourcesservice.data.enums.CreditCardBrand;
import com.example.fundingsourcesservice.repository.BankAccountRepository;
import com.example.fundingsourcesservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class FundingSourceService {

    @Autowired
    CreditCardRepository creditCards;

    @Autowired
    BankAccountRepository bankAccounts;

    public SourceCreatedDto createSourceFor(SourceDtoInterface aSource, String userId) throws Exception {

        SourceCreatedDto output;

        switch (aSource.getType()) {
            case TypeDiscriminator.CREDIT_CARD:
                // !!! Explicit cast type ...
                output = this.createCreditCardFor((CreditCardDto) aSource, userId);
                break;
            case TypeDiscriminator.BANK_ACCOUNT:
                // !!! Explicit cast type ...
                output = this.createBankAccountFor((BankAccountDto) aSource, userId);
                break;
            default:
                throw new Exception("Tipo de medio de financiación incorrecto.");
        }

        return output;
    }

    private SourceCreatedDto createBankAccountFor(BankAccountDto dto, String userId) {

        BankAccount bankAccountEntity = new BankAccount();

        // Base fields
        bankAccountEntity.setName(dto.getName());
        bankAccountEntity.setUserId(userId);
        bankAccountEntity.setCreatedAt(LocalDateTime.now());

        // Custom fields
        bankAccountEntity.setBankName(dto.getBankName());
        bankAccountEntity.setNumber(dto.getNumber());
        bankAccountEntity.setOwner(dto.getOwner());

        this.bankAccounts.save(bankAccountEntity);

        return new SourceCreatedDto(
                bankAccountEntity.getId(),
                bankAccountEntity.getName(),
                bankAccountEntity.getType(),
                bankAccountEntity.getCreatedAt()
        );
    }

    private SourceCreatedDto createCreditCardFor(CreditCardDto creditCard, String userId) {

        CreditCard creditCardEntity = new CreditCard();
        int bin = Integer.parseInt(creditCard.getNumber().substring(0, 5));
        int lastFour = Integer.parseInt(creditCard.getNumber().substring(creditCard.getNumber().length() - 4));

        // Base fields
        creditCardEntity.setName(creditCard.getName());
        creditCardEntity.setUserId(userId);
        creditCardEntity.setCreatedAt(LocalDateTime.now());

        // Custom fields
        creditCardEntity.setCardholderName(creditCard.getCardholderName());
        // TODO: Create a BIN Service ...
        creditCardEntity.setBrand(CreditCardBrand.UNKNOWN);
        creditCardEntity.setBin(bin);
        creditCardEntity.setLastFourDigits(lastFour);
        creditCardEntity.setExpirationDate(creditCard.getExpirationDate());

        this.creditCards.save(creditCardEntity);

        return new SourceCreatedDto(
                creditCardEntity.getId(),
                creditCardEntity.getName(),
                creditCardEntity.getType(),
                creditCardEntity.getCreatedAt()
        );
    }
}
