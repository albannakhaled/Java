package org.example.xml.controller;

import java.io.File;
import java.nio.file.Files;

import org.json.JSONObject;
import org.json.XML;

public class XML2JSON {
   public static void main(String[] args) {
      try {
         File file = new File(
               "/home/khaled/Desktop/programming/java/JavaSerialization/src/main/java/org/example/xml/source.xml");
         String xmlContent = new String(Files.readAllBytes(file.toPath()));
         JSONObject jsonObject = XML.toJSONObject(xmlContent);
         String prettiy = jsonObject.toString(4);
         System.out.println(prettiy);
      } catch (Exception e) {

      }
   }
}
