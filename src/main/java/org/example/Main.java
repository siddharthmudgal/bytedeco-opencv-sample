package org.example;

/**
 * make sure all imports are from bytedeco package name and not org.opencv
 * org.opencv package functionalities will not work with bytedeco
 */

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.PointerScope;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_java;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;

/**
 * main class
 */
public class Main {

    public static void main(String[] args) {

        // this loads bytedeco native libraries into the memory. First Step!
        Loader.load(opencv_java.class);

        //notice how imread is different from the original OpenCV jar wrapper provided by OpenCV org
        Mat mat = imread(Main.class.getClassLoader().getResource("sample.jpeg").getPath());

        if (mat == null)
            System.err.println("Unable to read image");

        System.out.println("Image dimensions -> " + mat.cols() + " x " + mat.rows());
        mat.release();

    }

}
