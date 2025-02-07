package DAC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAC.NADataHelperSQLite;
import DAC.DTO.NAHormigaDTO;
import Infra.AppException;

public class NAHormigaDAO extends NADataHelperSQLite implements NAIDAO<NAHormigaDTO> {

    private static final String SELECT_QUERY = "SELECT "
            + "IdHormiga, "
            + "IdCatalogoTipo, "
            + "IdCatalogoSexo, "
            + "IdCatalogoEstado, "
            + "IdCatalogoGenoAlimento, "
            + "IdCatalogoIngestaNativa, "
            + "Nombre, "
            + "Estado, "
            + "FechaCrea, "
            + "FechaModifica "
            + " FROM Hormiga WHERE Estado = 'A'";

    @Override
    public NAHormigaDTO newDTO(ResultSet rs) {
        try {
            return new NAHormigaDTO(
                    rs.getInt("IdHormiga"),
                    rs.getInt("IdCatalogoTipo"),
                    rs.getInt("IdCatalogoSexo"),
                    rs.getInt("IdCatalogoEstado"),
                    rs.getInt("IdCatalogoGenoAlimento"),
                    rs.getInt("IdCatalogoIngestaNativa"),
                    rs.getString("Nombre"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea"),
                    rs.getString("FechaModifica"));
        } catch (SQLException e) {
            new AppException(e, getClass().getName(), "newDTO()");
        }
        return null;
    }

    @Override
    public NAHormigaDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND IdHormiga = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    public List<NAHormigaDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT h.IdHormiga, " +
                "h.IdCatalogoTipo, " +
                "h.IdCatalogoSexo, " +
                "h.IdCatalogoEstado, " +
                "h.IdCatalogoGenoAlimento, " +
                "h.IdCatalogoIngestaNativa, " +
                "h.Nombre, " +
                "h.Estado, " +
                "h.FechaCrea, " +
                "h.FechaModifica " +
                " FROM Hormiga h " +
                " JOIN Catalogo c ON h.IdCatalogoTipo = c.IdCatalogo " +
                " WHERE c.Nombre = 'HormigaTipo' AND h.IdCatalogoTipo = ?";
        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<NAHormigaDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(NAHormigaDTO dto) throws Exception {
        String query = "INSERT INTO Hormiga ("
                + "IdCatalogoTipo, "
                + "IdCatalogoSexo, "
                + "IdCatalogoEstado, "
                + "IdCatalogoGenoAlimento, "
                + "IdCatalogoIngestaNativa, "
                + "Nombre, "
                + "Estado, "
                + "FechaCrea"
                + ") VALUES (?,?,?,?,?,?,?,?)";
        return execute(query,
                dto.getIdCatalogoTipo(),
                dto.getIdCatalogoSexo(),
                dto.getIdCatalogoEstado(),
                dto.getIdCataloGenoAlimento(),
                dto.getIdCataloIngestaNativa(),
                dto.getNombre(),
                dto.getEstado(),
                dto.getFechaCrea());
    }

    @Override
    public boolean update(NAHormigaDTO dto) throws Exception {
        String query = "UPDATE Hormiga SET "
                + "IdCatalogoTipo = ?, "
                + "IdCatalogoSexo = ?, "
                + "IdCatalogoEstado = ?, "
                + "IdCatalogoGenoAlimento = ?, "
                + "IdCatalogoIngestaNativa = ?, "
                + "Nombre = ?, "
                + "Estado = ?, "
                + "FechaModifica = ? "
                + "WHERE IdHormiga = ?";
        return execute(query,
                dto.getIdCatalogoTipo(),
                dto.getIdCatalogoSexo(),
                dto.getIdCatalogoEstado(),
                dto.getIdCataloGenoAlimento(),
                dto.getIdCataloIngestaNativa(),
                dto.getNombre(),
                dto.getEstado(),
                getDateTimeNow(),
                dto.getIdHormiga());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ?, FechaModifica = ? WHERE IdHormiga = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM NAHormiga WHERE estado = 'A'";
        return getMax(query);
    }

}
