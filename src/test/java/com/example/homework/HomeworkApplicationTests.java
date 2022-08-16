package com.example.homework;

import com.example.homework.models.File;
import com.example.homework.models.Folder;
import com.example.homework.models.User;
import com.example.homework.repositories.FileRepository;
import com.example.homework.repositories.FolderRepository;
import com.example.homework.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateUserFolderFile(){
		User user = new User("Raff");
		userRepository.save(user);

		Folder folder = new Folder("Data", user);
		folderRepository.save(folder);

		File file = new File("Docs", ".txt", 20, folder);
		fileRepository.save(file);
	}

	@Test
	public void addFilesToFolder(){
		User user = new User("Raff");
		userRepository.save(user);
		Folder folder = new Folder("Creative", user);
		folderRepository.save(folder);
		Folder folder2 = new Folder("Data", user);
		folderRepository.save(folder2);
		File file1 = new File("To-do", ".txt", 15, folder);
		fileRepository.save(file1);
		File file2 = new File("Slides", ".pdf", 250, folder);
		fileRepository.save(file2);
		File file3 = new File("Coupons", ".jpg", 33, folder2);
		fileRepository.save(file3);
		File file4 = new File("Numbers", ".docx", 22, folder2);
		fileRepository.save(file4);

		folder.addFile(file1);
		folder.addFile(file2);
		folder2.addFile(file3);
		folder2.addFile(file4);

		folderRepository.save(folder2);
		folderRepository.save(folder);
	}

}
