package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonControl {
    @Value("${sky.upload-path}") // 读取 yml 中的路径
    private String basePath;

    @PostMapping("/upload")
    @ApiOperation("文件上传")

    public Result<String> upload(MultipartFile file) {
        log.info("文件上传:{}", file);

        // 1. 获取原始文件名和后缀
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 2. 使用 UUID 重新生成文件名，防止重名导致覆盖
        String fileName = UUID.randomUUID() + extension;

        // 3. 检查目录是否存在，不存在则创建
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            // 4. 将临时文件转存到指定磁盘位置
            file.transferTo(new File(basePath + fileName));

            // 5. 返回文件的访问地址（或者只返回文件名，由前端拼接）
            return Result.success(fileName);
        } catch (IOException e) {
            log.error("文件上传失败:{}", e.getMessage());
            return Result.error("文件上传失败");
        }
    }
}

