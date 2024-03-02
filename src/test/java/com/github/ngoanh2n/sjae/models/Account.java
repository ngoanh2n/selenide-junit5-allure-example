package com.github.ngoanh2n.sjae.models;

import com.github.ngoanh2n.YamlData;
import com.github.ngoanh2n.YamlFrom;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ngoanh2n
 */
@Data
@EqualsAndHashCode(callSuper = true)
@YamlFrom(resource = "account.yml")
public class Account extends YamlData<Account> {
    private String username;
    private String password;

    public String toString() {
        return username + "/" + password;
    }
}
