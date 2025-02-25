package DAC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAC.NADataHelperSQLite;
import DAC.DTO.NACatalogoDTO;
import Infra.AppException;

public class NACatalogoDAO extends NADataHelperSQLite implements NAIDAO<NACatalogoDTO> {

    private static final String SELECT_QUERY = "SELECT "
            + "IdCatalogo, "
            + "IdCatalogoPadre, "
            + "Nombre, "
            + "Detalle, "
            + "Estado, "
            + "FechaCrea, "
            + "FechaModifica "
            + " FROM NACatalogo WHERE Estado = 'A";

    @Override
    public NACatalogoDTO newDTO(ResultSet rs) {
        try {
            return new NACatalogoDTO(
                    rs.getInt("IdCatalogo"),
                    rs.getInt("IdCatalogoPadre"),
                    rs.getString("Nombre"),
                    rs.getString("Detalle"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea"),
                    rs.getString("FechaModifica"));
        } catch (SQLException e) {
            new AppException(e, getClass().getName(), "NewDTO()");
        }
        return null;
    }

    @Override
    public NACatalogoDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND IdCatalogo = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    public List<NACatalogoDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT   h.IdCatalogo, " +
                "h.IdCatalogoPadre, " +
                "h.Nombre, " +
                "h.Detalle, " +
                "h.Estado, " +
                "h.FechaCrea, " +
                "h.FechaModifica " +
                " FROM NACatalogo p " +
                " JOIN NACatalogo h ON h.IdCatalogoPadre = p.IdCatalogo " +
                " WHERE h.Estado = 'A' AND p.IdCatalogo = ?";

        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<NACatalogoDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(NACatalogoDTO dto) throws Exception {
        String query = "INSERT INTO NACatalogo ("
                + "IdCatalogoPadre, "
                + "Nombre,"
                + "Detalle,"
                + "Estado,"
                + "FechaCrea"
                + ") VALUES (?,?,?,?,?)";
        return execute(query, dto.getIdCatalogoPadre(),
                dto.getNombre(),
                dto.getDetalle(),
                dto.getEstado(),
                dto.getFechaCrea());

    }

    @Override
    public boolean update(NACatalogoDTO dto) throws Exception {
        String query = "UPDATE NACatalogo SET "
                + "IdCatalogoPadre = ?, "
                + "Nombre = ?, "
                + "Detalle = ?, "
                + "FechaModifica = ? "
                + "WHERE IdCatalogo = ?";
        return execute(query, dto.getIdCatalogoPadre(),
                dto.getNombre(),
                dto.getDetalle(),
                getDateTimeNow(),
                dto.getIdCatalogo());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE NACatalogo SET Estado = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM NACatalogo WHERE estado = 'A'";
        return getMax(query);
    }

}
