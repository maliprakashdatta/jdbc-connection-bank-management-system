package com.swsa.service;
import java.sql.SQLException;
import java.util.Scanner;
import com.swsa.model.Card;
import com.swsa.repository.CardRepository;

public class CardService {

    private static final CardRepository CARD_REPOSITORY = new CardRepository();
    public void insertCard() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter cardId:");
        int cardId = Integer.parseInt(scanner.nextLine());

        System.out.println("Pls enter cardNo:");
        long cardNo = scanner.nextLong();

        System.out.println("Pls enter accountNo:");
        long accountNo= scanner.nextLong();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Pls enter  accountHolderName:");
        String accountHolderName = scanner1.nextLine();

        System.out.println("Pls enter cvv:");
        int cvv = scanner.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter your card type (Credit/Debit): ");
        String cardType = scanner2.nextLine().trim().toUpperCase();
        System.out.println(cardType.equals("CREDIT") ? "You have entered Credit." : cardType.equals("DEBIT") ? "You have entered Debit." : "Invalid input. Please enter 'Credit' or 'Debit'.");
        scanner2.close();

        Card card=new Card(cardId,cardNo, accountNo,accountHolderName,cvv,cardType);

        try {
            if (CARD_REPOSITORY.insertCard(card)) {
                System.out.println("Card inserted successfully!");
            } else {
                System.out.println("Failed to insert  Card.");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        }
}