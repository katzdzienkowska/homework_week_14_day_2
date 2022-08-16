package com.example.homework.components;

import com.example.homework.models.File;
import com.example.homework.models.Folder;
import com.example.homework.models.User;
import com.example.homework.repositories.FileRepository;
import com.example.homework.repositories.FolderRepository;
import com.example.homework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User oskar = new User("Oskar");
        userRepository.save(oskar);

        User kat = new User("Kat");
        userRepository.save(kat);

        User john = new User("John");
        userRepository.save(john);

        Folder folder1 = new Folder("Oskar's Photos", oskar);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Kat's Spreadsheets", kat);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("John's Spreadsheets", john);
        folderRepository.save(folder3);

        File file1 = new File("Memes", ".jpg", 80, folder1);
        fileRepository.save(file1);

        File file2 = new File("My buddies", ".png", 450, folder1);
        fileRepository.save(file2);

        File file3 = new File("Expenses", ".docx", 12, folder2);
        fileRepository.save(file3);

        File file4 = new File("Don't even remember", ".csv", 1234, folder2);
        fileRepository.save(file4);

        File file5 = new File("To-Do List", ".txt", 2, folder3);
        fileRepository.save(file5);

    }
}
