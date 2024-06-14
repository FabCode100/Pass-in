package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkin.Checkin;
import rocketseat.com.passin.repositories.CheckinRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CheckinService {
    private final CheckinRepository checkinRepository;

    public void checkinAttendee(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());
        Checkin newCheckIn = new Checkin();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId){
        this.checkinRepository.findByAttendeeId(attendeeId);
    }
}
