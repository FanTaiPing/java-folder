package me.zhengjie.classManager.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.classManager.domain.TbClass;
import me.zhengjie.classManager.service.dto.TbClassDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbClassMapperImpl implements TbClassMapper {

    @Override
    public TbClass toEntity(TbClassDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbClass tbClass = new TbClass();

        tbClass.setClassId( dto.getClassId() );
        tbClass.setCode( dto.getCode() );
        tbClass.setName( dto.getName() );
        tbClass.setClassStart( dto.getClassStart() );
        tbClass.setClassEnd( dto.getClassEnd() );
        tbClass.setType( dto.getType() );
        tbClass.setMTeacherId( dto.getMTeacherId() );
        tbClass.setMTeacherName( dto.getMTeacherName() );

        return tbClass;
    }

    @Override
    public TbClassDto toDto(TbClass entity) {
        if ( entity == null ) {
            return null;
        }

        TbClassDto tbClassDto = new TbClassDto();

        tbClassDto.setClassId( entity.getClassId() );
        tbClassDto.setCode( entity.getCode() );
        tbClassDto.setName( entity.getName() );
        tbClassDto.setClassStart( entity.getClassStart() );
        tbClassDto.setClassEnd( entity.getClassEnd() );
        tbClassDto.setType( entity.getType() );
        tbClassDto.setMTeacherId( entity.getMTeacherId() );
        tbClassDto.setMTeacherName( entity.getMTeacherName() );

        return tbClassDto;
    }

    @Override
    public List<TbClass> toEntity(List<TbClassDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbClass> list = new ArrayList<TbClass>( dtoList.size() );
        for ( TbClassDto tbClassDto : dtoList ) {
            list.add( toEntity( tbClassDto ) );
        }

        return list;
    }

    @Override
    public List<TbClassDto> toDto(List<TbClass> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbClassDto> list = new ArrayList<TbClassDto>( entityList.size() );
        for ( TbClass tbClass : entityList ) {
            list.add( toDto( tbClass ) );
        }

        return list;
    }
}
