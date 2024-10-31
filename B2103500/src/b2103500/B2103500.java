/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b2103500;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class B2103500 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhap tap hop A
        System.out.println("Nhập số lượng phần tử của tập hợp A:");
        int sizeA = scanner.nextInt();
        scanner.nextLine();

        Set<String> setA = new HashSet<>();
        System.out.println("Nhập các phần tử của tập hợp A:");
        for (int i = 0; i < sizeA; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ":");
            setA.add(scanner.nextLine());
        }

        // Nhap tap hop B
        System.out.println("Nhập số lượng phần tử của tập hợp B:");
        int sizeB = scanner.nextInt();
        scanner.nextLine();

        Set<String> setB = new HashSet<>();
        System.out.println("Nhập các phần tử của tập hợp B:");
        for (int i = 0; i < sizeB; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ":");
            setB.add(scanner.nextLine());
        }

        // Nhap quan he R
        System.out.println("Nhập số lượng cặp của quan hệ R:");
        int sizeR = scanner.nextInt();
        scanner.nextLine();

        Set<String> relationR = new HashSet<>();
        System.out.println("Nhập các cặp của quan hệ R (ví dụ: a,b):");
        for (int i = 0; i < sizeR; i++) {
            System.out.println("Cặp thứ " + (i + 1) + ":");
            relationR.add(scanner.nextLine());
        }

        System.out.println("------");
        System.out.println("------");
        // Tim phan tu x co thuoc tap A hay khong?
        System.out.println("Nhập phần tử cần tìm trong tập hợp A:");
        String x = scanner.nextLine();
        timPhanTu(setA, x);
        System.out.println("------");
        // Cac phep toan cua hai tap hop A va B
        //Giao
        //Hieu A - B
        //Hieu B - A
        //Tich Descartes A va B
        cacPheptoan2taphop(setA, setB);

        // Kiem tra cac quan he        
        // Quan he doi xung
        // Quan he bac cau
        // Quan he phan xa
        System.out.println("Quan hệ giữa A và tập R");
        kiemtraCacQuanHe(setA, relationR);
        System.out.println("------");
        System.out.println("Quan hệ giữa B và tập R");
        kiemtraCacQuanHe(setB, relationR);

        scanner.close();
    }

    private static void timPhanTu(Set<String> setA, String x) {
        if (setA.contains(x)) {
            System.out.println("Phần tử " + x + " có trong tập hợp A.");
        } else {
            System.out.println("Phần tử " + x + " không có trong tập hợp A.");
        }
    }

    private static void cacPheptoan2taphop(Set<String> setA, Set<String> setB) {
        // Giao của A và B
        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Giao của A và B: " + intersection);

        // Hợp của A và B
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Hợp của A và B: " + union);

        // Hiệu của A và B (A - B)
        Set<String> differenceAminusB = new HashSet<>(setA);
        differenceAminusB.removeAll(setB);
        System.out.println("Hiệu của A - B: " + differenceAminusB);

        // Hiệu của B và A (B - A)
        Set<String> differenceBminusA = new HashSet<>(setB);
        differenceBminusA.removeAll(setA);
        System.out.println("Hiệu của B - A: " + differenceBminusA);

        // Tích Descartes của A và B
        Set<String> cartesianProduct = new HashSet<>();
        for (String a : setA) {
            for (String b : setB) {
                cartesianProduct.add("(" + a + ", " + b + ")");
            }
        }
        System.out.println("Tích Descartes của A và B: " + cartesianProduct);
    }

    private static void kiemtraCacQuanHe(Set<String> setA, Set<String> relationR) {
        // Kiểm tra quan hệ đối xứng
        boolean isSymmetric = true;
        for (String pair : relationR) {
            String[] elements = pair.split(",");
            String a = elements[0];
            String b = elements[1];
            if (relationR.contains(b + "," + a)) {
                continue;
            }
            isSymmetric = false;
            break;
        }
        if (isSymmetric) {
            System.out.println("Quan hệ đối xứng: Yes");
        } else {
            System.out.println("Quan hệ đối xứng: No");
        }
        // Kiểm tra quan hệ bắc cầu
        boolean isTransitive = true;
        for (String pair1 : relationR) {
            String[] elements1 = pair1.split(",");
            String a1 = elements1[0];
            String b1 = elements1[1];
            for (String pair2 : relationR) {
                String[] elements2 = pair2.split(",");
                String b2 = elements2[0];
                String c2 = elements2[1];
                if (b1.equals(b2) && !relationR.contains(a1 + "," + c2)) {
                    isTransitive = false;
                    break;
                }
            }
            if (!isTransitive) {
                break;
            }
        }
        if (isTransitive) {
            System.out.println("Quan hệ bắc cầu: Yes");
        } else {
            System.out.println("Quan hệ bắc cầu: No");
        }
        // Kiểm tra quan hệ phản xạ
        boolean isReflexive = true;
        for (String a : setA) {
            if (!relationR.contains(a + "," + a)) {
                isReflexive = false;
                break;
            }
        }
        if (isReflexive) {
            System.out.println("Quan hệ phản xạ: Yes");
        } else {
            System.out.println("Quan hệ phản xạ: No");
        }
    }
}
