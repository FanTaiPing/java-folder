package me.zhengjie.workinfo.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.workinfo.domain.TbWorkInfo;
import me.zhengjie.workinfo.service.dto.TbWorkInfoDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbWorkInfoMapperImpl implements TbWorkInfoMapper {

    @Override
    public TbWorkInfo toEntity(TbWorkInfoDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbWorkInfo tbWorkInfo = new TbWorkInfo();

        tbWorkInfo.setTbWorkInfoId( dto.getTbWorkInfoId() );
        tbWorkInfo.setInfoDesc( dto.getInfoDesc() );
        tbWorkInfo.setProess( dto.getProess() );
        tbWorkInfo.setWorkId( dto.getWorkId() );
        tbWorkInfo.setComment( dto.getComment() );
        tbWorkInfo.setWorkName( dto.getWorkName() );
        tbWorkInfo.setTakeTime( dto.getTakeTime() );
        tbWorkInfo.setState( dto.getState() );

        return tbWorkInfo;
    }

    @Override
    public TbWorkInfoDto toDto(TbWorkInfo entity) {
        if ( entity == null ) {
            return null;
        }

        TbWorkInfoDto tbWorkInfoDto = new TbWorkInfoDto();

        tbWorkInfoDto.setTbWorkInfoId( entity.getTbWorkInfoId() );
        tbWorkInfoDto.setInfoDesc( entity.getInfoDesc() );
        tbWorkInfoDto.setProess( entity.getProess() );
        tbWorkInfoDto.setWorkId( entity.getWorkId() );
        tbWorkInfoDto.setComment( entity.getComment() );
        tbWorkInfoDto.setWorkName( entity.getWorkName() );
        tbWorkInfoDto.setTakeTime( entity.getTakeTime() );
        tbWorkInfoDto.setState( entity.getState() );

        return tbWorkInfoDto;
    }

    @Override
    public List<TbWorkInfo> toEntity(List<TbWorkInfoDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbWorkInfo> list = new ArrayList<TbWorkInfo>( dtoList.size() );
        for ( TbWorkInfoDto tbWorkInfoDto : dtoList ) {
            list.add( toEntity( tbWorkInfoDto ) );
        }

        return list;
    }

    @Override
    public List<TbWorkInfoDto> toDto(List<TbWorkInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbWorkInfoDto> list = new ArrayList<TbWorkInfoDto>( entityList.size() );
        for ( TbWorkInfo tbWorkInfo : entityList ) {
            list.add( toDto( tbWorkInfo ) );
        }

        return list;
    }
}
