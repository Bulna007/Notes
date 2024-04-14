package com.jaxrsclient.test;

import com.jaxrsclient.async.invoker.DoctorAsyncCallbackInvoker;
import com.jaxrsclient.async.invoker.DoctorAsyncInvoker;

import java.util.concurrent.ExecutionException;

public class JaxrsAsyncClientTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        DoctorAsyncInvoker asyncInvoker = new DoctorAsyncInvoker();
//        asyncInvoker.showDoctorWithAppointments(39);
        DoctorAsyncCallbackInvoker asyncCallbackInvoker = new DoctorAsyncCallbackInvoker();
        asyncCallbackInvoker.showDoctorWithAppointments(2);
    }
}
