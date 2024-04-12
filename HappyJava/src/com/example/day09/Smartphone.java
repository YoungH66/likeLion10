package com.example.day09;

public class Smartphone {
    public interface Camera{
        void takePhoto();
    }
    public class BasicCamera implements Camera{
        @Override
        public void takePhoto() {
            System.out.println("take a photo");
        }
    }

    public void activateCamera(){
        Camera camera = new BasicCamera();
        camera.takePhoto();
    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        smartphone.activateCamera();
    }
}
