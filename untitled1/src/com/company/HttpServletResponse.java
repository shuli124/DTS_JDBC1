package com.company;

import javax.servlet.*;
import java.io.*;

public interface HttpServletResponse extends ServletResponse {
    void setContentType(String type);
}