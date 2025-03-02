package model;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Network {

    /**
     * récupérer l'adresse locale (matériel) sur
     * n'importe quel OS
     * @return String mac Address as 48 bits (6 octets/bytes)
     */
    public static String getMacAddress() {
        String res = null;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            boolean found = false;
            while (interfaces.hasMoreElements() && !found) {
                NetworkInterface networkInterface = interfaces.nextElement();
                // Ignore loopback interfaces and virtual one
                if (networkInterface.isLoopback()
                || networkInterface.isVirtual()
                || networkInterface.getHardwareAddress() == null) {
                    continue;
                }
                String name = networkInterface.getName().toLowerCase();
                String displayName = networkInterface.getDisplayName().toLowerCase();
                // priority to 'aux' interfaces "enX" (Mac/Linux) and Ethernet (Windows)
                if (!(name.startsWith("en")
                || displayName.contains("ethernet")
                || name.startsWith("eth"))) {
                    continue;
                }
                // recover mac address
                byte[] macAddressBytes = networkInterface.getHardwareAddress();
                if (macAddressBytes == null) {
                    continue;
                }
                // convert mac address into a readable format
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < macAddressBytes.length; i++) {
                    macAddress.append(String.format("%02X", macAddressBytes[i]));
                    if (i < macAddressBytes.length - 1) {
                        macAddress.append(":");
                    }
                }
                res = String.valueOf(macAddress);
                found = true;
            }
            //System.out.println("no Ethernet interface ('enX' or equivalent) found.");
        } catch (SocketException e) {
            System.err.println("error in NetworkConnection.getMacAddress() : "+e);
        }
        return res;
    }
}
