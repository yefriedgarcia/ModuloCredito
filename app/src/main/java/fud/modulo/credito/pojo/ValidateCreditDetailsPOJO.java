package fud.modulo.credito.pojo;

public class ValidateCreditDetailsPOJO {

    private String amountMin; //monto minimo que puede solicitar
    private String amounMax; //monto maximo que puede solicitar
    private String dateLimit; //fecha maxima que debe devolver
    private String tax; // tarifa que se va a cobrar por el prestamo; ejemplo 0,01
    private String info; //mensaje informativo sobre el prestamo

    public ValidateCreditDetailsPOJO(String amountMin, String amounMax, String dateLimit, String tax, String info) {
        this.amountMin = amountMin;
        this.amounMax = amounMax;
        this.dateLimit = dateLimit;
        this.tax = tax;
        this.info = info;
    }

    public String getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(String amountMin) {
        this.amountMin = amountMin;
    }

    public String getAmounMax() {
        return amounMax;
    }

    public void setAmounMax(String amounMax) {
        this.amounMax = amounMax;
    }

    public String getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(String dateLimit) {
        this.dateLimit = dateLimit;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
