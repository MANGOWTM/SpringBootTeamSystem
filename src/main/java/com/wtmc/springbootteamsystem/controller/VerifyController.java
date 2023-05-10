package com.wtmc.springbootteamsystem.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
public class VerifyController {

    private final Producer captchaProducer;

    @Autowired
    public VerifyController(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String captchaText = captchaProducer.createText();
            request.getSession().setAttribute("captchaText", captchaText);

            BufferedImage captchaImage = captchaProducer.createImage(captchaText);
            ImageIO.write(captchaImage, "jpg", response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/captcha")
    public boolean verifyCaptcha(HttpServletRequest request, @RequestBody Map<String, String> data) {
        String captchaText = (String) request.getSession().getAttribute("captchaText");
        String inputCaptchaText = data.get("captchaText");
        return captchaText != null && captchaText.equals(inputCaptchaText);
    }
}
