package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.ArtistDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Artist;
import com.artflake.artgallery.repository.ArtistRepository;
import com.artflake.artgallery.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ArtistDto> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream().map(artist -> modelMapper.map(artist, ArtistDto.class)).toList();
    }

    @Override
    public ArtistDto getArtistById(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Artist not found"));
        ArtistDto artistDto = modelMapper.map(artist, ArtistDto.class);
        return artistDto;
    }

    @Override
    public ApiResponse createArtist(ArtistDto artistDto) {
        Artist artist = modelMapper.map(artistDto, Artist.class);
        artistRepository.save(artist);
        return new ApiResponse("Inserted artist successfully");
    }

    @Override
    public ApiResponse updateArtist(Long id, ArtistDto artistDto) {
        Artist artist = artistRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Artist not found"));
        modelMapper.map(artistDto, artist);
        artistRepository.save(artist);
        return new ApiResponse("Updated artist successfully");
    }

    @Override
    public ApiResponse deleteArtist(Long id) {
        if (artistRepository.existsById(id)) {
            artistRepository.deleteById(id);
            return new ApiResponse("Deleted artist successfully");
        } else {
            throw new ResourceNotFoundException("Artist not found");
        }
    }
}
