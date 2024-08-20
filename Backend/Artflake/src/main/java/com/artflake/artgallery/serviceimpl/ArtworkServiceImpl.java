package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.ArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Artist;
import com.artflake.artgallery.model.Artwork;
import com.artflake.artgallery.repository.ArtworkRepository;
import com.artflake.artgallery.repository.ArtistRepository;
import com.artflake.artgallery.service.ArtworkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArtworkServiceImpl implements ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ArtworkDto> getAllArtworks() {
        List<Artwork> artworks = artworkRepository.findAll();
        return artworks.stream()
                .map(artwork -> {
                    ArtworkDto artworkDto = modelMapper.map(artwork, ArtworkDto.class);
                    artworkDto.setArtistId(artwork.getArtist().getId());
                    artworkDto.setArtistName(artwork.getArtist().getName());
                    return artworkDto;
                }).toList();
    }

    @Override
    public ArtworkDto getArtworkById(Long id) {
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artwork not found"));
        ArtworkDto artworkDto = modelMapper.map(artwork, ArtworkDto.class);
        artworkDto.setArtistName(artwork.getArtist().getName());
        return artworkDto;
    }

    @Override
    public List<ArtworkDto> getArtworksByArtistId(Long artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        List<Artwork> artworks = artworkRepository.findByArtist(artist);
        return artworks.stream()
                .map(artwork -> {
                    ArtworkDto artworkDto = modelMapper.map(artwork, ArtworkDto.class);
                    artworkDto.setArtistId(artist.getId());
                    artworkDto.setArtistName(artist.getName());
                    return artworkDto;
                }).toList();
    }
    @Override
    public ApiResponse createArtwork(ArtworkDto artworkDto) {
        Artist artist = artistRepository.findById(artworkDto.getArtistId())
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        Artwork artwork = modelMapper.map(artworkDto, Artwork.class);
        artwork.setArtist(artist);

        artworkRepository.save(artwork);

        return new ApiResponse("Inserted artwork successfully");
    }

    @Override
    public ApiResponse updateArtwork(Long id, ArtworkDto artworkDto) {

        System.out.println(artworkDto.getId());
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artwork not found"));

        Artist artist = artistRepository.findById(artworkDto.getArtistId())
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));

        modelMapper.map(artworkDto, artwork);
        artwork.setArtist(artist);

        if (artworkDto.getArtistId() == null) {
            throw new ResourceNotFoundException("Artist ID must not be null");
        }


        artworkRepository.save(artwork);

        return new ApiResponse("Updated artwork successfully");
    }

    @Override
    public ApiResponse deleteArtwork(Long id) {
        if (artworkRepository.existsById(id)) {
            artworkRepository.deleteById(id);
            return new ApiResponse("Deleted artwork successfully");
        } else {
            throw new ResourceNotFoundException("Artwork not found");
        }
    }
}