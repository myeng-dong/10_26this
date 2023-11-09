package com.kh.com.kh.web.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FileTest {
  private Long uploadfileId;
  private String table_info;
  private Long table_id;
  private String store_filename;
  private String upload_filename;
  private String fsize;
  private String ftype;
  private LocalDateTime cdate;
}
