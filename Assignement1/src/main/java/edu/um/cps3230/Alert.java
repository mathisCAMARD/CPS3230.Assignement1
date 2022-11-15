package edu.um.cps3230;

public class Alert {
    private String title;
    private String descripion;
    private String url;
    private String imageUrl;
    private String price;

    public Alert(String title, String descripion, String url, String imageUrl, String price){
        this.title = title;
        this.descripion = descripion;
        this.imageUrl = imageUrl;
        this.url = url;
        this.price = price;
    }

    public static void displayAlert(Alert alert){
        System.out.println("title : " + alert.title);
        System.out.println("descripion : " + alert.descripion);
        System.out.println("imageUrl : " + alert.imageUrl);
        System.out.println("url : " + alert.url);
        System.out.println("price : " + alert.price);

    }

    public String getTitle(){
        return this.title;
    }

    public String getDescripion(){
        return this.descripion;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public String getUrl(){
        return this.url;
    }

    public String getPrice(){
        return this.price;
    }
}
