public class Main {
    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay); //แปลง xpay เป็น PayD

        // Print values from the adapted PayD interface
        System.out.println("Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Card Owner Name: " + payD.getCardOwnerName());
//        payD.setCardExpMonthYear("2413"); ทดลองใช้ setCardExpMonthYear ว่าดึงปีเดือนถูกต้องไหม
        System.out.println("Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());
    }
}