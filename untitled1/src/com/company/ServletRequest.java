package com.company;

import java.io.*;

public interface ServletRequest {
    PrintWriter getWriter() throws IOException;
}