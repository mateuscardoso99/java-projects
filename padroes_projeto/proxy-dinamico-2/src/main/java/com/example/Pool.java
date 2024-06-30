package com.example;

import java.sql.Connection;

public interface Pool {
    Connection acquire();
}
