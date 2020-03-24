package com.vivienda.api.dto;

public class PermisoUsuarioDTO {

    private TipoUsuarioDTO tipoUsuario;
    private Integer permiso;
    private String pagina;

    public PermisoUsuarioDTO() {
    }

    public PermisoUsuarioDTO(TipoUsuarioDTO tipoUsuario, Integer permiso, String pagina){
        this.tipoUsuario = tipoUsuario;
        this.permiso = permiso;
        this.pagina = pagina;
    }

    public TipoUsuarioDTO getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioDTO tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getPermiso() {
        return permiso;
    }

    public void setPermiso(Integer permiso) {
        this.permiso = permiso;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
