package com.pb.frolov.hw7;

public class Atelier {
    public static void main(String[] args) {
        Skirt skirt1 = new Skirt( Size.XS,500,"black");
        Pants pants1 = new Pants(Size.XXS, 255,"grey");
        Tie tie1 = new Tie(Size.L,120,"blue");
        Tshirt tshirt1 = new Tshirt(Size.M,300,"white");
        Skirt skirt2 = new Skirt( Size.L,540,"red");
        Tie tie2 = new Tie(Size.M,125,"black");
        Pants pants2 = new Pants(Size.XS, 240,"brown");


        Clothes[] clothes = {skirt1,pants1,tie1,tshirt1,skirt2,tie2,pants2};


        System.out.println("\n----------getEuroSize(Size size)----------");
        int i=0;
        for (Clothes a: clothes){
            System.out.println((++i)+": "+a.getClass().getSimpleName()+
                    " размер " +Size.getEuroSize(a.getSize()));
        }

        System.out.println("\n----------getDescription(Size size)----------");
        i=0;
        for (Clothes a: clothes){
            System.out.print((++i)+": "+a.getClass().getSimpleName()+ " " );
            Size.getDescription(a.getSize());
            System.out.print("\n");
        }

        //выводят информацию о одежде
        pants1.dressWoman();
        pants2.dressMan();
        skirt1.dressWoman();
        tie2.dressMan();


        System.out.println("\nПолная информацию о мужской одежде");
        dressMan(clothes);
        System.out.println("\nПолная информацию о женской одежде");
        dressWoman(clothes);
    }

    //dressMan выводит на консоль всю информацию о мужской одежде
    static void dressMan(Clothes[] clothes){
        for (Clothes a: clothes){
            if (a instanceof ManClothes){
                System.out.println(a.getClass().getSimpleName()+": размер "
                        + a.getSize()+", цвет "+a.getColor()+", цена "+a.getPrice());
            }
        }
    }

    //dressWomen выводит на консоль всю информацию о женской одежде
    static void dressWoman(Clothes[] clothes){
        for (Clothes a: clothes){
            if (a instanceof WomenClothes){
                System.out.println(a.getClass().getSimpleName()+": размер "
                        + a.getSize()+", цвет "+a.getColor()+", цена "+a.getPrice());
            }
        }
    }

}
