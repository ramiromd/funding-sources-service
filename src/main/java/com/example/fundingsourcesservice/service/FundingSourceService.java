package com.example.fundingsourcesservice.service;

import com.example.fundingsourcesservice.data.*;
import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import com.example.fundingsourcesservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FundingSourceService {

    @Autowired
    CreditCardRepository creditCards;

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

    private SourceCreatedDto createCreditCardFor(CreditCardDto dto, String userId) {
        return new SourceCreatedDto(1L, dto.getName(), dto.getType(), LocalDateTime.now());
    }

    private SourceCreatedDto createBankAccountFor(BankAccountDto dto, String userId) {
        return new SourceCreatedDto(1L, dto.getName(), dto.getType(), LocalDateTime.now());
    }

    /*
    public SourceCreatedDto createCreditCardFor(CreditCardDto creditCard, String userId) {

        CreditCard creditCardEntity = new CreditCard();
        int bin = Integer.parseInt(creditCard.getNumber().substring(0, 5));
        int lastFour = Integer.parseInt(creditCard.getNumber().substring(creditCard.getNumber().length() - 4));

        // Base fields
        creditCardEntity.setName(creditCard.getName());
        creditCardEntity.setUserId(userId);
        creditCardEntity.setCreatedAt(LocalDateTime.now());

        // Custom fields
        creditCardEntity.setCardholderName(creditCard.getCardholderName());
        creditCardEntity.setBin(bin);
        creditCardEntity.setLastFourDigits(lastFour);

        this.creditCards.save(creditCardEntity);

        return new SourceCreatedDto(
                creditCardEntity.getId(),
                creditCardEntity.getName(),
                creditCardEntity.getType(),
                creditCardEntity.getCreatedAt()
        );
    }
    */
}
