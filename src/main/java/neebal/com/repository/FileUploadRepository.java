
package neebal.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neebal.com.entity.UploadedFile;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFile,String> {
	
	Boolean existsByfileId(String id);
	
}
