package com.pb.frolov.hw7;

public enum Size {
    XXS("детский размер",32),
    XS("взрослый размер",34),
    S("взрослый размер",36),
    M("взрослый размер",38),
    L("взрослый размер",40);

    private String description;
    private int eurosize;

    Size(String description, int eurosize) {
        this.description= description;
        this.eurosize=eurosize;
    }

    public static void getDescription(Size size){
    //    if (size==XXS){
    //        System.out.println("Детский размер");
    //    }
    //    else System.out.println("Взрослый размер");

        System.out.print(size.description);
    }

    public static int getEuroSize(Size size){
/*      int intSize=0;
        switch (size){
            case XXS:
                intSize=  32;
                break;
            case XS:
                intSize=  34;
                break;
            case S:
                intSize=  36;
                break;
            case M:
                intSize=  38;
                break;
            case L:
                intSize=  40;
                break;
            } */

    return size.eurosize;
    }
}
