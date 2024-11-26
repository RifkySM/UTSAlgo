import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double grandTotal = 0, discountedTotal = 0;
        String receipt = "Nama Barang \t\t | Harga Barang \t | Qty \t | Harga Total \t | Diskon\n-----------------------------------------------------------------------";
        Scanner input = new Scanner(System.in);
        String more = "Y";
        System.out.println("Selamat Datang di Toko Elektronik :)");

        do {
            System.out.println("Masukkan Nama Barang : ");
            String productName = input.nextLine();

            if (productName.isEmpty()) {
                System.out.println("Nama Barang tidak valid.");
                continue;
            }

            System.out.println("Masukkan Harga Barang Per Item : ");
            if (!input.hasNextDouble()) {
                System.out.println("Harga tidak valid.");
                input.next();
                continue;
            }
            double productPrice = input.nextDouble();

            System.out.println("Masukkan Jumlah Barang : ");
            if (!input.hasNextInt()) {
                System.out.println("Jumlah tidak valid.");
                input.next();
                continue;
            }
            int productQty = input.nextInt();
            input.nextLine();

            double total = productPrice * productQty;
            double discount = 0;
            if (productQty >= 5) {
                discount = total * 10 / 100;
            } else if (productQty >= 3) {
                discount = total * 5 / 100;
            }

            grandTotal += total;
            discountedTotal += discount;

            receipt += String.format("\n%-20s | %-15.2f | %-4d | %-15.2f | %-7.2f", productName, productPrice, productQty, total, discount);

            System.out.println("Apakah Anda ingin menambahkan produk lain? (Y/N)");
            more = input.next();
            input.nextLine();
        } while (more.equalsIgnoreCase("Y"));


        receipt += "\n-----------------------------------------------------------------------\n";
        receipt += String.format("Harga Total\t\t\t%.2f\n", grandTotal);
        receipt += String.format("Diskon\t\t\t\t%.2f\n", discountedTotal);
        receipt += "-----------------------------------------------------------------------\n";
        receipt += String.format("Grand Total\t\t\t%.2f\n", grandTotal - discountedTotal);

        System.out.println(receipt);
        System.out.println("Terima Kasih Telah Berbelanja :)");
    }
}
