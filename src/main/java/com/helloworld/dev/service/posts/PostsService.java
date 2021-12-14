package com.helloworld.dev.service.posts;

import com.helloworld.dev.domain.posts.Posts;
import com.helloworld.dev.domain.posts.PostsRepository;
import com.helloworld.dev.web.dto.PostsResponseDto;
import com.helloworld.dev.web.dto.PostsSaveRequestDto;
import com.helloworld.dev.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        // update 쿼리 날리는 부분 없는 이유 -> JPA 영속성 컨텍스트 때문
        // 영속성 컨텍스트란? -> 엔티티를 영구저장하는 환경
        // 트랜잭션 안에서 데이터베이스의 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태.
        // 이 상태에서 데이터 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경된 데이터를 반영한다.
        // 즉, Entity 객체 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없게 된다.
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다.id="+id));

        return new PostsResponseDto(entity);

    }
}
