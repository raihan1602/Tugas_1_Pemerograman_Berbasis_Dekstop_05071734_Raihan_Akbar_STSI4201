
import java.util.Scanner;


//Prodi : Sistem Informsi 


public class praktekTugasSatu {

    static class Menu {
        String nama;
        int harga;
        String kategori;

        Menu(String nama, int harga, String kategori) {
            this.nama = nama;
            this.harga = harga;
            this.kategori = kategori;
        }
    }

    //kelas utama Main

    public static class Main {
        static Menu[] menu = {

            //list menu makanan 
            new Menu("Nasgor Goreng     ", 20000, "Makanan"),
            new Menu("Nasi Kuning Putih ", 15000, "Makanan"),
            new Menu("Mie Goreng Kuah   ", 15000, "Makanan"),
            new Menu("Bakso Uranium     ", 25000, "Makanan"),

            //list minumannnnn
            new Menu("Es Teh Panas      ", 8000, "Minuman"),
            new Menu("Kopi Hitam Putih  ", 10000, "Minuman"),
            new Menu("Jus Mengkudu      ", 15000, "Minuman"),
            new Menu("Air Normal        ", 5000, "Minuman"),
        };

        //Method

        static void spasi() {
            System.out.println("\n");
        }

        static void tampilanMenu() {

            System.out.println(">>>   Menu Makanan   <<<");
            System.out.println();
            System.out.println(" 1. " + menu[0].nama + " : " + menu[0].harga);
            System.out.println(" 2. " + menu[1].nama + " : " + menu[1].harga);
            System.out.println(" 3. " + menu[2].nama + " : " + menu[2].harga);
            System.out.println(" 4. " + menu[3].nama + " : " + menu[3].harga);

            System.out.println();
            System.out.println();

            System.out.println(">>>   Menu Minuman   <<<");
            System.out.println(" 5. " + menu[4].nama + " : " + menu[4].harga);
            System.out.println(" 6. " + menu[5].nama + " : " + menu[5].harga);
            System.out.println(" 7. " + menu[6].nama + " : " + menu[6].harga);
            System.out.println(" 8. " + menu[7].nama + " : " + menu[7].harga);

        }

        static Menu pilihMenu(int pilihan) {
            switch (pilihan) {
                case 1 : return menu[0];
                case 2 : return menu[1];
                case 3 : return menu[2];
                case 4 : return menu[3];
                case 5 : return menu[4];
                case 6 : return menu[5];
                case 7 : return menu[6];
                case 8 : return menu[7];
                default: return null;
            }
        }

        static int hitungItem(Menu m, int jumlah) {
            if(m != null) {
                return m.harga * jumlah;
            }
            else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new  Scanner(System.in);

        Main.spasi();

        Main.tampilanMenu();

        Main.spasi();


        System.out.println(">>>   Input Pesanan Makanan Atau Minuman (Max 4)   <<<");
        System.out.println(">>>   NOMOR 1 - 4 (Makanan), NOMOR 5 - 8 (Minuman)    <<<<");
        System.out.println();

        System.out.print("Berapa jenis Pesanan Yang Ingin Dipesan : ");
        int jumlahPesanan = input.nextInt();

        int[] pesan = new int[4];
        int[] jumlah = new int[4]; 

        for(int i = 0; i < jumlahPesanan; i++) {
            System.out.println();

            System.out.print("Pesanan " + (i + 1) + " Pilih Nomor Menu : ");
            pesan[i] = input.nextInt();

            System.out.print("Jumlah : ");
            jumlah[i] = input.nextInt();
        }

        Menu[] m = new Menu[4];
        int[] tot = new int[4];

        for(int i = 0; i < jumlahPesanan; i++) {
            m[i] = Main.pilihMenu(pesan[i]);
            tot[i] = Main.hitungItem(m[i], jumlah[i]);
        }

        int total = 0;
        for(int i = 0; i < jumlahPesanan; i++) {
            total += tot[i];
        }

        double diskon = 0;
        boolean promoMinuman = false;

        if(total > 100000) {
            diskon = total * 0.10;
        }
        else if (total > 50000) {
            for(int i = 0; i < jumlahPesanan; i++) {
                if(m[i] != null && m[i].kategori.equals("Minuman")) {
                    promoMinuman = true;
                }
            }
        }

        double totalSetelahDiskon = total - diskon;
        double pajak = totalSetelahDiskon * 0.10;

        int service = 20000;

        double totalAkhir = totalSetelahDiskon + pajak + service;

        Main.spasi();

        System.out.println(">>>   Struk Pemesanan   <<<");
        Main.spasi();

        for(int i = 0; i < jumlahPesanan; i++) {
            if(m[i] !=null) {
                System.out.println(m[i].nama + " x " + jumlah[i] + " = " + tot[i]);
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Total: ");

        if(diskon > 0) {
            System.out.println("Diskon 10%      : " + diskon);
        }
        else if(promoMinuman) {
            System.out.println("Promo: Beli 1 GRATIS 1 Minuman");
        }
        else {
            System.out.println("Tidak Ada Promo");
        }

        System.out.println("Setelah Diskon      : " + totalSetelahDiskon);
        System.out.println("Pajak 10%           : " + pajak);
        System.out.println("Service             : " + service);
        System.out.println("TOTAL BAYAR         : " + totalAkhir);

        Main.spasi();

    }

}
