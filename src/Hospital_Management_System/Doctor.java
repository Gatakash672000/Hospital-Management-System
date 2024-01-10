//package Hospital_Management_System;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//
//public class Doctor {
//    private Connection connection;
//
//
//
//    public  Doctor(Connection connection){
//        this.connection = connection;
//
//    }
////    public void addpatient(){
////        System.out.print("Enter Patient Name:- ");
////        String name = scanner.next();
////        System.out.print("Enter Patient Age:- ");
////        int age = scanner.nextInt();
////        System.out.println("Enter Patient Gender:- ");
////        String gender = scanner.next();
////
////        try {
////            String query ="insert into patients(name,age,gender) values(?,?,?)";
////            PreparedStatement preparedStatement = connection.prepareStatement(query);
////            preparedStatement.setString(1,name);
////            preparedStatement.setInt(2,age);
////            preparedStatement.setString(3,gender);
////
////            int affectedRows =preparedStatement.executeUpdate();
////
////            if(affectedRows>0){
////                System.out.println("Patient Added Successfully");
////            }else {
////                System.out.println("Failed to add Patients!!");
////            }
////
////
////        }catch (SQLException e){
////            e.printStackTrace();
////        }
////    }
////
//
//    public  void viewDoctor(){
//        String query="select * from Doctors";
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet= preparedStatement.executeQuery();
//            System.out.println("Doctors: ");
//            System.out.println("+------------+------------------------+------------------------+");
//            System.out.println("| Doctor Id  |       Name             |    Specialization      |");
//            System.out.println("+------------+------------------------+------------------------+");
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("dr_name");
//                String specialization =resultSet.getString("specialization");
//                System.out.printf("| %-10s | %-22s | %-21s |\n",id,name,specialization);
//                System.out.println("+------------+------------------------+-----------------------+");
//
//
//
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public  boolean getDoctorById(int id){
//        String query = "select * from Doctors where id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            if(resultSet.next()){
//                return true;
//            }else {
//                return false;
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection){
        this.connection = connection;
    }

    public void viewDoctors(){
        String query = "select * from doctors";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| Doctor Id  | Name               | Specialization   |");
            System.out.println("+------------+--------------------+------------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-10s | %-18s | %-16s |\n", id, name, specialization);
                System.out.println("+------------+--------------------+------------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id){
        String query = "SELECT * FROM doctors WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}