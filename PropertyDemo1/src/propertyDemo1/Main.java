package propertyDemo1;




import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bill electricalBill = new Bill();

		electricalBill.amountDueProperty().addListener((ov, oldVal, newVal) -> {
			System.out.println("Rachunek zmieniono z:" + 
					oldVal.toString() + " na " + newVal.toString());
		});
		
		electricalBill.setAmountDue(22.0);
		electricalBill.setAmountDue(40.0);
		electricalBill.setAmountDue(67.0);
		// ======================================================
		
		IntegerProperty num1 = new SimpleIntegerProperty(1);
		IntegerProperty num2 = new SimpleIntegerProperty(5);
		IntegerProperty num3 = new SimpleIntegerProperty(6);
		
		NumberBinding sum = num1.add(num2);
		NumberBinding total = Bindings.add(num1, num2.multiply(num3));
		
		System.out.println("sum przed: " + sum.getValue());
		System.out.println("total po: " + total.getValue());

		num2.set(500);
		System.out.println("sum przed: " + sum.getValue());
		System.out.println("total po: " + total.getValue());
		// ======================================================
		
		Bill bill1 = new Bill();
		Bill bill2 = new Bill();
		Bill bill3 = new Bill();
		
		NumberBinding totalBill = Bindings.add(bill1.amountDueProperty(),
						bill2.amountDueProperty().add(bill3.amountDueProperty())
						);
		totalBill.addListener(
				observable -> System.out.println("Wiązanie nieważne")
				);
		
		bill1.setAmountDue(10.0);	// invalidation listener
		bill2.setAmountDue(20.0);
		bill3.setAmountDue(30.0);
		System.out.println("totalBill: " + totalBill.getValue());
		bill1.setAmountDue(30.0);	// invalidation listener
		bill3.setAmountDue(40.0);
		System.out.println("totalBill: " + totalBill.getValue());
		// ========================================================

		Bill bill10 = new Bill();
		Bill bill20 = new Bill();
		Bill bill30 = new Bill();
		
		NumberBinding totalBill2 = Bindings.add(bill10.amountDueProperty(),
						bill20.amountDueProperty().add(bill30.amountDueProperty())
						);
		totalBill2.addListener(
				(observable_value , old_val, new_val) -> 
				System.out.println("Wiązanie nieważne")
				);
		
		bill10.setAmountDue(10.0);	// change listener
		bill20.setAmountDue(20.0);	// change listener
		bill30.setAmountDue(30.0);	// change listener
		System.out.println("totalBill: " + totalBill2.getValue());
		bill10.setAmountDue(30.0);	// change listener
		bill30.setAmountDue(40.0);	// change listener
		System.out.println("totalBill: " + totalBill2.getValue());
		
		
	}

}
