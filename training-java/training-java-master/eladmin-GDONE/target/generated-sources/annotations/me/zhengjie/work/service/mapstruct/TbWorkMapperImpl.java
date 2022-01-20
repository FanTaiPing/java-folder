package me.zhengjie.work.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.work.domain.TbWork;
import me.zhengjie.work.service.dto.TbWorkDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbWorkMapperImpl implements TbWorkMapper {

    @Override
    public TbWork toEntity(TbWorkDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbWork tbWork = new TbWork();

        tbWork.setName( dto.getName() );
        tbWork.setProess( dto.getProess() );
        tbWork.setWorkId( dto.getWorkId() );
        tbWork.setWorkCode( dto.getWorkCode() );
        tbWork.setWorkDesc( dto.getWorkDesc() );
        tbWork.setCrTeacherId( dto.getCrTeacherId() );
        tbWork.setCrTeacherName( dto.getCrTeacherName() );
        tbWork.setCrClassId( dto.getCrClassId() );
        tbWork.setCrStudentId( dto.getCrStudentId() );
        tbWork.setWorkState( dto.getWorkState() );
        tbWork.setCrClassName( dto.getCrClassName() );
        tbWork.setCrStudentName( dto.getCrStudentName() );

        return tbWork;
    }

    @Override
    public TbWorkDto toDto(TbWork entity) {
        if ( entity == null ) {
            return null;
        }

        TbWorkDto tbWorkDto = new TbWorkDto();

        tbWorkDto.setName( entity.getName() );
        tbWorkDto.setProess( entity.getProess() );
        tbWorkDto.setWorkId( entity.getWorkId() );
        tbWorkDto.setWorkCode( entity.getWorkCode() );
        tbWorkDto.setWorkDesc( entity.getWorkDesc() );
        tbWorkDto.setCrTeacherId( entity.getCrTeacherId() );
        tbWorkDto.setCrTeacherName( entity.getCrTeacherName() );
        tbWorkDto.setCrClassId( entity.getCrClassId() );
        tbWorkDto.setCrStudentId( entity.getCrStudentId() );
        tbWorkDto.setWorkState( entity.getWorkState() );
        tbWorkDto.setCrClassName( entity.getCrClassName() );
        tbWorkDto.setCrStudentName( entity.getCrStudentName() );

        return tbWorkDto;
    }

    @Override
    public List<TbWork> toEntity(List<TbWorkDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbWork> list = new ArrayList<TbWork>( dtoList.size() );
        for ( TbWorkDto tbWorkDto : dtoList ) {
            list.add( toEntity( tbWorkDto ) );
        }

        return list;
    }

    @Override
    public List<TbWorkDto> toDto(List<TbWork> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbWorkDto> list = new ArrayList<TbWorkDto>( entityList.size() );
        for ( TbWork tbWork : entityList ) {
            list.add( toDto( tbWork ) );
        }

        return list;
    }
}
