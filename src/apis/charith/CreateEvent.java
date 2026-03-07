// creates a new in-game event. admin level function.

package apis.charith;

import DBConnection;
import java.sql.*;
import java.util.Scanner;

public class CreateEvent {

    public static void Client_CreateEvent(Scanner scanner) {

        System.out.println("\n--- Create Event (Admin) ---");

        System.out.print("Enter event name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter reward XP (just the number): ");
        String xpInput = scanner.nextLine().trim();

        int rewardXP;
        try {
            rewardXP = Integer.parseInt(xpInput);
        } catch (NumberFormatException e) {
            System.out.println("Error: XP must be a number.");
            return;
        }

        String result = Server_CreateEvent(name, description, rewardXP);
        System.out.println(result);
    }

    public static String Server_CreateEvent(String name, String description, int rewardXP) {

        Connection conn = null;

        try {
            conn = DBConnection.getConnection();

            String checkSql = "SELECT ID FROM Events WHERE Name = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, name);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                checkStmt.close();
                return "Error: An event named '" + name + "' already exists.";
            }
            checkStmt.close();

            String sql =
                "INSERT INTO Events (Name, Description, RewardXP) " +
                "VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, rewardXP);

            stmt.executeUpdate();
            stmt.close();

            return "Success: Event '" + name + "' created with " + rewardXP + " XP reward.";

        } catch (SQLException e) {
            return "Database error: " + e.getMessage();
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}