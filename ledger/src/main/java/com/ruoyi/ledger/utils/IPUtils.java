package com.ruoyi.ledger.utils;

import java.util.ArrayList;
import java.util.List;

public class IPUtils {
    public static void main(String[] args) {
        int len = 24;
        System.out.println();
        System.out.println(getAllIPs("192.168.1.0",len,false));
        System.out.println(getAllIPs("192.168.1.0",len,false).size());
    }
    public static List<String> getAllIPs(String gateway, int subnetMaskBits,boolean includeAll) {
        List<String> allIPs = new ArrayList<>();
        // 将网关和子网掩码转换为二进制
        String gatewayBinary = convertToBinary(gateway);
        String subnetMaskBinary = generateSubnetMask(subnetMaskBits);

        // 获取子网中第一个IP地址
        String firstIP = calculateFirstIP(gatewayBinary, subnetMaskBinary);
        if (includeAll) {
            allIPs.add(firstIP);
        }

        // 获取子网中最后一个IP地址
        String lastIP = calculateLastIP(gatewayBinary, subnetMaskBinary);
        if (includeAll) {
            allIPs.add(lastIP);
        }

        // 获取子网中除了第一个和最后一个之外的其他IP地址
        String currentIP = incrementIP(firstIP);
        while (!currentIP.equals(lastIP)) {
            allIPs.add(currentIP);
            currentIP = incrementIP(currentIP);
        }

        return allIPs;
    }

    private static String convertToBinary(String IP) {
        String[] IPArray = IP.split("\\.");
        StringBuilder binaryIP = new StringBuilder();

        for (String octet : IPArray) {
            String binaryOctet = Integer.toBinaryString(Integer.parseInt(octet));

            // 补全8位二进制数
            while (binaryOctet.length() < 8) {
                binaryOctet = "0" + binaryOctet;
            }

            binaryIP.append(binaryOctet);
        }

        return binaryIP.toString();
    }

    private static String generateSubnetMask(int subnetMaskBits) {
        if (subnetMaskBits < 0 || subnetMaskBits > 32) {
            throw new IllegalArgumentException("Subnet mask bits should be between 0 and 32");
        }

        StringBuilder subnetMask = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            subnetMask.append(i < subnetMaskBits ? '1' : '0');
        }
        return subnetMask.toString();
    }

    private static String calculateFirstIP(String gatewayBinary, String subnetMaskBinary) {
        StringBuilder firstIP = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if (subnetMaskBinary.charAt(i) == '1') {
                firstIP.append(gatewayBinary.charAt(i));
            } else {
                firstIP.append('0');
            }
        }

        return convertToDecimal(firstIP.toString());
    }

    private static String calculateLastIP(String gatewayBinary, String subnetMaskBinary) {
        StringBuilder lastIP = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if (subnetMaskBinary.charAt(i) == '1') {
                lastIP.append(gatewayBinary.charAt(i));
            } else {
                lastIP.append('1');
            }
        }

        return convertToDecimal(lastIP.toString());
    }

    private static String convertToDecimal(String binaryIP) {
        StringBuilder decimalIP = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octet = Integer.parseInt(binaryIP.substring(i * 8, (i + 1) * 8), 2);
            decimalIP.append(octet);
            if (i != 3) {
                decimalIP.append(".");
            }
        }
        return decimalIP.toString();
    }

    private static String incrementIP(String ip) {
        String[] octets = ip.split("\\.");
        int[] values = new int[4];
        for (int i = 0; i < 4; i++) {
            values[i] = Integer.parseInt(octets[i]);
        }
        values[3]++;
        for (int i = 3; i >= 0; i--) {
            if (values[i] > 255) {
                values[i] = 0;
                if (i - 1 >= 0) {
                    values[i - 1]++;
                }
            }
        }
        return values[0] + "." + values[1] + "." + values[2] + "." + values[3];
    }
}
