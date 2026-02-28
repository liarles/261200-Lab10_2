public class XpayToPayDAdapter implements PayD{

    private final Xpay xpay; //use xpay as base

    public XpayToPayDAdapter(Xpay xpay){
        this.xpay = xpay; //ทุกอย่างคือของ xpay
    }
    @Override
    public long getCreditCardNo() {
        return Long.parseLong(xpay.getCreditCardNo()); //แปลง int เป็น long
    }

    @Override
    public String getCardOwnerName() {
        return xpay.getCustomerName();
    }

    @Override
    public String getCardExpMonthYear() {
        return xpay.getCardExpMonth() + "/" + xpay.getCardExpYear(); //รวมปีและเดือน
    }

    @Override
    public Integer getCVVNo() {
        return Integer.parseInt(String.valueOf(xpay.getCardCVVNo())); //แปลง short เป็น int
    }

    @Override
    public Double getTotalAmount() {
        return xpay.getAmount();
    }

    @Override
    public void setCreditCardNo(long creditCardNo) {
        xpay.setCreditCardNo(String.valueOf(creditCardNo)); //แปลง long เป็น string
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        xpay.setCardExpMonth(cardExpMonthYear.substring(0,2)); //เอาเดือน โดยการดึง string สองตัวหน้า
        xpay.setCardExpYear(cardExpMonthYear.substring(2,4)); //เอาปี โดยการดึง string สองตัวถัดมา

    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        xpay.setCardCVVNo((short) Integer.parseInt(String.valueOf(cVVNo))); //แปลง short เป็น integer

    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        xpay.setAmount(totalAmount);

    }
}
