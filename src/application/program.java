package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		List<Product> produtos = new ArrayList<>();
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char x = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price:");
			Double price = sc.nextDouble();
			if (x == 'c') {
				Product p1 = new Product(name, price);
				produtos.add(p1);
			} else if (x == 'i') {
				System.out.print("Custom fee:");
				Double customfee = sc.nextDouble();
				ImportedProduct impP = new ImportedProduct(name, price, customfee);
				produtos.add(impP);
			} else if (x == 'u') {
				System.out.print("Manufacture Date(dd/MM/yyy): ");
				Date mf = sdf.parse(sc.next());
				UsedProduct up = new UsedProduct(name, price, mf);
				produtos.add(up);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : produtos) {
			System.out.println(product.priceTag());
		}

		sc.close();

	}
}
