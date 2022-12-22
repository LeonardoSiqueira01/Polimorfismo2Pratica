package entities;

public class ImportedProduct extends Product {
	private Double customsFee; // taxa personalizada

	public Double getCustomsFee() {
		return customsFee;
	}

	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return super.getName() + ", $" + totalPrice() + "(Customs fee: $ " + customsFee + ")";
	}

	public Double totalPrice() {
		return super.getPrice() + customsFee;
	}

}
