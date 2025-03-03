package com.example.permissionsystem.util;

import java.util.Base64;

public class GenerateSecretKey {
  public static void main(String[] args) {
    String secretKey = "password"; // 替换为你的密钥
    String base64SecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    System.out.println("Base64 Secret Key: " + base64SecretKey);
  }
}
