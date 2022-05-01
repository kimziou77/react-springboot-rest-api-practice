package com.example.gccoffee.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

@EqualsAndHashCode // 이메일이 같으면 같다 VO를 만들때 이것을 달아주어야 함.
@ToString
@Getter
public class Email {

    private final String address;

    public Email(String address){
        Assert.notNull(address, "address should not be null");
        Assert.isTrue(address.length() >= 4 && address.length() <= 50, "address length must be betwwen 4 and 50 characters.");
        Assert.isTrue(checkAddress(address), "Invalid email address");
        this.address = address;

    }

    private static boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b",address);
    }


}
