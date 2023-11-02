package com.resinj.boot;

import com.resinj.automaticparam.api.ShipmentApiService;
import com.resinj.beanparam.RentalPropertyApiService;
import com.resinj.cookieparam.UberCabApiService;
import com.resinj.formparam.ParcelApiService;
import com.resinj.headerparam.NetbankingApiService;
import com.resinj.httpheaders.WorkScheduleManagerApiService;
import com.resinj.matrixparams.ProductApiService;
import com.resinj.pathsegment.CarApiService;
import com.resinj.queryparamwithdefaultval.PlanApiService;
import com.resinj.uriinfo.TourApiService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ResourceInjectionApplication extends Application {
    private Set<Class<?>> classes;
    private Set<Object> singletons;

    public ResourceInjectionApplication() {
        classes = new HashSet<>();
        singletons = new HashSet<>();

        classes.add(ProductApiService.class);
        classes.add(PlanApiService.class);
        classes.add(NetbankingApiService.class);
        classes.add(ParcelApiService.class);
        classes.add(UberCabApiService.class);
        classes.add(RentalPropertyApiService.class);
        classes.add(CarApiService.class);
        classes.add(TourApiService.class);
        classes.add(WorkScheduleManagerApiService.class);
        classes.add(ShipmentApiService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
