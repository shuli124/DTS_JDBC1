package com.company;

import java.io.*;

public interface ServletResponse {
    PrintWriter getWriter() throws IOException;
}