package neebal.com.DTO;


public class UploadedFileDTO {
	
 
    private String fileId;
    private String fileName;
    private String fileType;
    
    private byte[] fileData;

  

	public UploadedFileDTO() {
		super();
	}

	public UploadedFileDTO(String fileId) {
		super();
		this.fileId = fileId;
	
	}

	public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
}
