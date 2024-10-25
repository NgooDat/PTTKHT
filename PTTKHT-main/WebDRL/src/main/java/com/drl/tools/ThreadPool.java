package com.drl.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    
    //Giới hạn tối đa 10 luồng xử lý trong chương trình (thuê 10 nhân viên làm việc)
    public static final ExecutorService executorService = Executors.newFixedThreadPool(5);

}
