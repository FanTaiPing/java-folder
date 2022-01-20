package me.zhengjie.teacher.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.teacher.domain.TbTeacher;
import me.zhengjie.teacher.service.dto.TbTeacherDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbTeacherMapperImpl implements TbTeacherMapper {

    @Override
    public TbTeacher toEntity(TbTeacherDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbTeacher tbTeacher = new TbTeacher();

        tbTeacher.setTeacherId( dto.getTeacherId() );
        tbTeacher.setName( dto.getName() );
        tbTeacher.setSex( dto.getSex() );
        tbTeacher.setAge( dto.getAge() );
        tbTeacher.setEducation( dto.getEducation() );
        tbTeacher.setEducationMajor( dto.getEducationMajor() );
        tbTeacher.setTeachMajor( dto.getTeachMajor() );
        tbTeacher.setTechnicalTitle( dto.getTechnicalTitle() );
        tbTeacher.setPostname( dto.getPostname() );
        tbTeacher.setPositionNature( dto.getPositionNature() );
        tbTeacher.setTelNumber( dto.getTelNumber() );
        tbTeacher.setQqNumber( dto.getQqNumber() );
        tbTeacher.setWxNumber( dto.getWxNumber() );
        tbTeacher.setJobweekStart( dto.getJobweekStart() );
        tbTeacher.setJobweekEnd( dto.getJobweekEnd() );
        tbTeacher.setEntryTime( dto.getEntryTime() );

        return tbTeacher;
    }

    @Override
    public TbTeacherDto toDto(TbTeacher entity) {
        if ( entity == null ) {
            return null;
        }

        TbTeacherDto tbTeacherDto = new TbTeacherDto();

        tbTeacherDto.setTeacherId( entity.getTeacherId() );
        tbTeacherDto.setName( entity.getName() );
        tbTeacherDto.setSex( entity.getSex() );
        tbTeacherDto.setAge( entity.getAge() );
        tbTeacherDto.setEducation( entity.getEducation() );
        tbTeacherDto.setEducationMajor( entity.getEducationMajor() );
        tbTeacherDto.setTeachMajor( entity.getTeachMajor() );
        tbTeacherDto.setTechnicalTitle( entity.getTechnicalTitle() );
        tbTeacherDto.setPostname( entity.getPostname() );
        tbTeacherDto.setPositionNature( entity.getPositionNature() );
        tbTeacherDto.setTelNumber( entity.getTelNumber() );
        tbTeacherDto.setQqNumber( entity.getQqNumber() );
        tbTeacherDto.setWxNumber( entity.getWxNumber() );
        tbTeacherDto.setJobweekStart( entity.getJobweekStart() );
        tbTeacherDto.setJobweekEnd( entity.getJobweekEnd() );
        tbTeacherDto.setEntryTime( entity.getEntryTime() );

        return tbTeacherDto;
    }

    @Override
    public List<TbTeacher> toEntity(List<TbTeacherDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbTeacher> list = new ArrayList<TbTeacher>( dtoList.size() );
        for ( TbTeacherDto tbTeacherDto : dtoList ) {
            list.add( toEntity( tbTeacherDto ) );
        }

        return list;
    }

    @Override
    public List<TbTeacherDto> toDto(List<TbTeacher> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbTeacherDto> list = new ArrayList<TbTeacherDto>( entityList.size() );
        for ( TbTeacher tbTeacher : entityList ) {
            list.add( toDto( tbTeacher ) );
        }

        return list;
    }
}
