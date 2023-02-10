package com.example.LibraryManagementApplication.service;

import com.example.LibraryManagementApplication.model.Library;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {
    private static List<Library> libraryManage = new ArrayList<>();
    static int autoNum = 0;
    static{
        libraryManage.add(new Library("Allahabad University Gov Library", "Prayagraj, India", ++autoNum, 45));
        libraryManage.add(new Library("Sumitranandan Pant Baal Udyan", "Prayagraj, India", ++autoNum, 25));
        libraryManage.add(new Library("Khudabaksha Oriental Library", "Patna, Bihar", ++autoNum, 47));
        libraryManage.add(new Library("Nehru memorial Museum & Library", "Delhi, India", ++autoNum, 53));
        libraryManage.add(new Library("Goa State Central Library", "Panji, Goa", ++autoNum, 65));
    }

    public List<Library> getAllLibraries() {
        return libraryManage;
    }

    public Library getLibrary(String name) {
        for (Library library: libraryManage){
            if(library.getName().equals(name)) return library;
        }
        return null;
    }

    public String addLibrary(Library library) {
        libraryManage.add(new Library(library.getName(),
                library.getAddress(),
                ++autoNum,
                library.getFaculties()));
        return library.getName() + " Added Successfully!";
    }

    public String updateLibrary(Library library, String name) {
        Library oldLibrary = this.getLibrary(name);
        if(oldLibrary != null) {
            if (library.getName() != null) oldLibrary.setName(library.getName());
            if (library.getFaculties() != 0) oldLibrary.setFaculties(library.getFaculties());
            if (library.getAddress() != null) oldLibrary.setAddress(library.getAddress());
            if (library.getNumber() != 0) oldLibrary.setNumber(library.getNumber());
            return "Library with name " + name + " Updated Successfully";
        }
        else return "Library not found to Update, Add library first";
    }

    public String deleteLibrary(String name) {
        Library library = this.getLibrary(name);
        if(library != null) {
            libraryManage.remove(library.getNumber()-1);
            return "Library with name " + name + " Deleted Successfully";
        }
        else return "Library not found to Delete, Add library first";
    }
}
