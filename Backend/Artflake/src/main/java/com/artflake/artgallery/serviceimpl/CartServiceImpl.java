package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.CartDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Artwork;
import com.artflake.artgallery.model.Cart;
import com.artflake.artgallery.model.CartItem;
import com.artflake.artgallery.repository.ArtworkRepository;
import com.artflake.artgallery.repository.CartItemRepository;
import com.artflake.artgallery.repository.CartRepository;
import com.artflake.artgallery.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ArtworkRepository artworkRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream()
                .map(cart -> modelMapper.map(cart, CartDto.class))
                .toList();
    }

    @Override
    public CartDto getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        return modelMapper.map(cart, CartDto.class);
    }

//    @Override
//    public List<CartItemDto> getCartItemsByUserId(Long userId) {
//        Cart cart = cartRepository.findByUserId(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id " + userId));
//
//        List<CartItem> cartItems = cartItemRepository.findByCart(cart);
//
//        return cartItems.stream()
//                .map(cartItem -> {
//                    Artwork artwork = artworkRepository.findById(cartItem.getArtwork().getId())
//                            .orElseThrow(() -> new ResourceNotFoundException("Artwork not found"));
//                    CartItemDto cartItemDto = new CartItemDto();
//                    cartItemDto.setCartItemId(cartItem.getCartItemId());
//                    cartItemDto.setCartId(cart.getId());
//                    cartItemDto.setArtworkId(artwork.getId());
//                    cartItemDto.setArtworkPrice(artwork.getPrice());
//                    cartItemDto.setArtworkTitle(artwork.getTitle());
//                    cartItemDto.setQuantity(cartItem.getQuantity());
//                    cartItemDto.setAddedAt(cartItem.getAddedAt());
//                    cartItemDto.setArtworkImageUrl(artwork.getImage());
//                    return cartItemDto; // Return the mapped CartItemDto object
//                })
//                .toList();
//    }


//    @Override
//    public List<CartItemDto> getCartItemsByCartId(Long cartId) {
//        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);
//        List<CartItemDto> cartItemDtos = new ArrayList<>();
//
//        for (CartItem cartItem : cartItems) {
//            Artwork artwork = artworkRepository.findById(cartItem.getArtwork().getId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Artwork not found"));
//
//            CartItemDto cartItemDto = new CartItemDto();
//            cartItemDto.setCartItemId(cartItem.getCartItemId());
//            cartItemDto.setCartId(cartItem.getCart().getId());
//            cartItemDto.setArtworkId(artwork.getId());
//            cartItemDto.setQuantity(cartItem.getQuantity());
//            cartItemDto.setAddedAt(cartItem.getAddedAt());
//            cartItemDto.setArtworkTitle(artwork.getTitle());
//            cartItemDto.setArtistDescription(artwork.getDescription());
//            cartItemDto.setArtworkPrice(artwork.getPrice());
//            cartItemDto.setArtworkImageUrl(artwork.getImage());
//
//            cartItemDtos.add(cartItemDto);
//        }
//
//        return cartItemDtos;
//    }

    @Override
    public ApiResponse addArtworkToCart(Long userId, Long artworkId) {
        // Retrieve the cart or create a new one for the user
        Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            return cartRepository.save(newCart);
        });

        // Retrieve the artwork by ID
        Artwork artwork = artworkRepository.findById(artworkId).orElseThrow(() ->
                new ResourceNotFoundException("Artwork not found"));

        // Create a new CartItem for the artwork
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setArtwork(artwork);
        cartItem.setQuantity(1);

        // Save the cart item
        cartItemRepository.save(cartItem);

        return new ApiResponse("Artwork added to cart successfully!");
    }
    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByCartUserId(userId);
    }

    @Override
    public ApiResponse createCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cartRepository.save(cart);
        return new ApiResponse("Inserted cart successfully");
    }

    @Override
    public ApiResponse updateCart(Long id, CartDto cartDto) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        modelMapper.map(cartDto, cart);
        cartRepository.save(cart);
        return new ApiResponse("Updated cart successfully");
    }

    @Override
    public ApiResponse deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return new ApiResponse("Deleted cart successfully");
        } else {
            throw new ResourceNotFoundException("Cart not found");
        }
    }
}
