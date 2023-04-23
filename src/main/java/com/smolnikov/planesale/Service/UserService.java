package com.smolnikov.planesale.Service;

import com.smolnikov.planesale.Entity.ReservationEntity;
import com.smolnikov.planesale.Entity.User;
import com.smolnikov.planesale.Repository.ReservationRepo;
import com.smolnikov.planesale.Repository.UserRepo;
import com.smolnikov.planesale.Response.CartRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo repo;

    private final ReservationRepo reservationRepo;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepo repo, PasswordEncoder encoder, ReservationRepo reservationRepo) {
        this.repo = repo;
        this.encoder = (BCryptPasswordEncoder) encoder;
        this.reservationRepo = reservationRepo;
    }

    public boolean addUser(String userName, String Password){
//        if(repo.findByUsername(userName) != null) {
//            return false;
//        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(encoder.encode(Password));
        repo.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String addToCart(CartRequest cartRequest) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setFlightCode(cartRequest.getFlightCode());
        reservationEntity.setName(cartRequest.getName());
        reservationEntity.setSurname(cartRequest.getSurname());
        reservationEntity.setEmail(cartRequest.getEmail());
        reservationEntity.setPhone(cartRequest.getPhone());
        User user = repo.findByUsername(cartRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        reservationEntity.setUser(user);
        reservationRepo.save(reservationEntity);
        return "success";
    }
}