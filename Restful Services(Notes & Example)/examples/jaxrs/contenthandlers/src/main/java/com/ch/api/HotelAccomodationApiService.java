package com.ch.api;

import com.ch.dto.ReservationDetailsDto;
import com.ch.dto.RoomBookingRequestDto;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.StreamingOutput;

import java.io.InputStream;
import java.security.SecureRandom;
import java.util.UUID;

@Path("/accomodation")
public class HotelAccomodationApiService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StreamingOutput reserveRoom(InputStream ins) {
        RoomBookingRequestDto roomBookingRequestDto = null;
        final Jsonb jsonb = JsonbBuilder.create();

        roomBookingRequestDto = jsonb.fromJson(ins, RoomBookingRequestDto.class);

        final ReservationDetailsDto reservationDetailsDto = new ReservationDetailsDto();
        reservationDetailsDto.setReservationNo(UUID.randomUUID().toString());
        reservationDetailsDto.setRoomType(roomBookingRequestDto.getRoomType());
        reservationDetailsDto.setFullname(roomBookingRequestDto.getFullname());
        reservationDetailsDto.setRoomNo(new SecureRandom().nextInt(100));
        reservationDetailsDto.setAmount(new SecureRandom().nextDouble(5000));
        reservationDetailsDto.setCheckoutTime("10:00 AM");
        reservationDetailsDto.setCheckinTime("4:00 PM");
        reservationDetailsDto.setBookingStatus("Confirmed");
        return (os) -> {
            jsonb.toJson(reservationDetailsDto, os);
            os.close();
        };
    }
}
